package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by M on 2018/7/3.
 */
public interface IFileService {

    String upload(MultipartFile file, String path) ;

}
