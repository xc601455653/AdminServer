package xyz.wsyzz.candy.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import xyz.wsyzz.candy.common.ResultData;
import xyz.wsyzz.candy.entity.TO.SendMailParamTO;
import xyz.wsyzz.candy.entity.VO.UploadFileResponse;
import xyz.wsyzz.candy.service.FileService;
import xyz.wsyzz.candy.util.ResultDataUtils;
import xyz.wsyzz.candy.util.SendEmailUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xucan on 2022/2/26.
 */
@RestController
@RequestMapping("commontool")
@Api(description = "通用工具服务", tags = {"CommonToolController"})
public class CommonToolController {

    private static final Logger logger = LoggerFactory.getLogger(CommonToolController.class);

    @Autowired
    private FileService fileService;

    @ApiOperation("发送邮件服务")
    @PostMapping("sendmail")
    public ResultData sendMail(@RequestBody SendMailParamTO sendMailParamTO) throws Exception{
        if (CollectionUtils.isEmpty(sendMailParamTO.getToMailAddressList())) {
            return ResultDataUtils.exception("收件人邮箱地址不能为空");
        }
        if (StringUtils.isEmpty(sendMailParamTO.getContent())) {
            return ResultDataUtils.exception("内容不能为空");
        }
        SendEmailUtils.sendMailByParam(sendMailParamTO);
        return ResultDataUtils.success();
    }

    @ApiOperation("单个文件上传服务")
    @PostMapping("uploadFile")
    public ResultData uploadFile(@RequestParam("file") MultipartFile file){
        String fileName = fileService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/commontool/")
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        UploadFileResponse fileResponse = new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
        return ResultDataUtils.success(fileResponse);
    }

    @ApiOperation("多个文件上传服务")
    @PostMapping("uploadMultipleFiles")
    public ResultData uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        List<UploadFileResponse> collect = Arrays.stream(files)
                .map(file -> {
                    String fileName = fileService.storeFile(file);

                    String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                            .path("/commontool/")
                            .path("/downloadFile/")
                            .path(fileName)
                            .toUriString();
                    return new UploadFileResponse(fileName, fileDownloadUri,
                            file.getContentType(), file.getSize());
                })
                .collect(Collectors.toList());
        return ResultDataUtils.success(collect);
    }

    @ApiOperation("文件下载服务")
    @GetMapping("downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileService.loadFileAsResource(fileName);
        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.",ex);
        }
        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}
