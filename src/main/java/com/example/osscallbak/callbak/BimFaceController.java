package com.example.osscallbak.callbak;

import com.bimface.api.bean.response.FileTranslateBean;
import com.bimface.exception.BimfaceException;
import com.bimface.file.bean.FileBean;
import com.bimface.sdk.BimfaceClient;
import io.swagger.annotations.ApiOperation;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.Data;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: pzy
 * @create: 2019/12/31 14:54
 */
@RestController
@RequestMapping("/api/v1/bim/face")
public class BimFaceController {

    @GetMapping("/viewToken/integrate/{integrateId}")
//    @ApiOperation(value = "根据集成模型id获取viewToken")
    String findViewToken(@PathVariable Long integrateId) throws BimfaceException {
        BimfaceClient bimfaceClient = new BimfaceClient(BimFaceConst.APP_KEY, BimFaceConst.APP_SECRET);
        return bimfaceClient.getViewTokenByIntegrateId(integrateId);
    }

    @GetMapping("/viewToken/file/{fileId}")
//    @ApiOperation(value = "根据模型id获取viewToken")
    String findFileViewToken(@PathVariable Long fileId) throws BimfaceException {
        BimfaceClient bimfaceClient = new BimfaceClient(BimFaceConst.APP_KEY, BimFaceConst.APP_SECRET);
        return bimfaceClient.getViewTokenByFileId(fileId);
    }

    @PostMapping("/upFile")
    @ResponseBody
    @ApiOperation(value = "文件上传并自动转换")
    public FileBean  upFile(@RequestParam("name") String name) throws BimfaceException, FileNotFoundException {

        BimfaceClient bimfaceClient = new BimfaceClient(BimFaceConst.APP_KEY, BimFaceConst.APP_SECRET);
            String na = name;
        File fi = null;
        InputStream inputStreams = null;
        MultipartFile multipartFile = null;
// PUSH方式
//            InputStream inputStream = file.getInputStream();
            fi= new File("/data/阿里巴巴Java开发手册终极版v1.3.0.rvt");
            /*if(na.equals("1")){
                inputStreams= new FileInputStream(fi);
                multipartFile = new MockMultipartFile(fi.getName(), inputStreams);
                inputStreams = multipartFile.getInputStream();
            }else if(na.equals("2")){
                 fi = new File("/data/阿里巴巴Java开发手册终极版v1.3.0.rvt");
                inputStreams= new FileInputStream(fi);
                multipartFile = new MockMultipartFile(fi.getName(), inputStreams);
                inputStreams = multipartFile.getInputStream();
            }else if(na.equals("3")){
                fi = new File("/data/阿里巴巴Java开发手册终极版v1.3.0.rvt");
                inputStreams= new FileInputStream(fi);
                multipartFile = new MockMultipartFile(fi.getName(), inputStreams);
                inputStreams = multipartFile.getInputStream();
            }*/
            SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            System.out.println("上传开始时间"+ sim.format(new Date()));
        String url = "";
            if(name.equals("1")){
                url= "http://localhost:8080/file:E:/"+fi.getName();
            }else{
                 url = "http://39.105.63.212\\file\\"+fi.getName();
            }
//            FileBean fileBean = bimfaceClient.upload(fi.getName(), fi.length(), inputStreams);
            FileBean fileBean = bimfaceClient.upload(fi.getName(), ""+fi.getName());
            System.out.println("上传结束时间时间"+sim.format(new Date()));
            return fileBean;
//            FileTranslateBean translate = bimfaceClient.translate(fileBean.getFileId());
//            System.out.println("完成");
    }

    public String getFileUrl(){


        return "";
    }

    @GetMapping("/getTranslate/{fileId}")
    @ApiOperation(value = "根据fileid查询转换状态")
    public FileTranslateBean  gettranslate(@PathVariable Long fileId) throws BimfaceException {
        BimfaceClient bimfaceClient = new BimfaceClient(BimFaceConst.APP_KEY, BimFaceConst.APP_SECRET);
        FileTranslateBean translate = bimfaceClient.getTranslate(fileId);
        return translate;
    }

}
