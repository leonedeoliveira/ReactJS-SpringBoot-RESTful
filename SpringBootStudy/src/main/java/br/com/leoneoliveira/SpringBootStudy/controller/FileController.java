package br.com.leoneoliveira.SpringBootStudy.controller;

import br.com.leoneoliveira.SpringBootStudy.data.vo.UploadFileResponseVO;
import br.com.leoneoliveira.SpringBootStudy.services.FileStorageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "FileEndPoint")
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping(value = "/uploadFile")
    public UploadFileResponseVO uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/file/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponseVO(fileName, fileDownloadUri, file.getContentType(), file.getSize());
    }

    @PostMapping(value = "/uploadMultipleFile")
    public List<UploadFileResponseVO> uploadMultipleFile(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

}
