package com.example.commodity.tools;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;

public class FileUpload {

    public static String writeUploadFile(MultipartFile file, String module) {
        String filename = file.getOriginalFilename();
        String realpath = "D:/rentHouse/" + module + "/";
        File fileDir = new File(realpath);
        if (!fileDir.exists())
            fileDir.mkdirs();

        String extname = FilenameUtils.getExtension(filename);
        String allowImgFormat = "jpg,png";
        if (!allowImgFormat.contains(extname.toLowerCase())) {
            return "NOT_IMAGE";
        }

        filename = UUID.randomUUID().toString().replace("-", "") + "." + extname;
        InputStream input = null;
        FileOutputStream fos = null;

        try {
            input = file.getInputStream();
            fos = new FileOutputStream(realpath + filename);
            IOUtils.copy(input, fos);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            IOUtils.closeQuietly(input);
            IOUtils.closeQuietly(fos);
        }
        return filename;
    }
}
