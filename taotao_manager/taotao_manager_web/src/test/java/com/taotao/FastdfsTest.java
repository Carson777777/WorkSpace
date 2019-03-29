package com.taotao;

import org.csource.fastdfs.*;
import org.junit.Test;

public class FastdfsTest  {
    @Test
    public void testUpload()throws Exception{
        //初始化全局配置
        ClientGlobal.init("F:\\business\\taotao_manager\\taotao_manager_web\\src\\main\\resources\\client.conf");
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageServer storageServer = null;
        StorageClient storageClient = new StorageClient(trackerServer,storageServer);
        String[] strings =  storageClient.upload_file("F:\\alignment_1.jpg","jpg",null);
        for(String string : strings){
            System.out.println(string);
        }

    }
    @Test
    public void TestFastDFSClient() throws Exception{
        FastDFSClient  client = new FastDFSClient("F:\\business\\taotao_manager\\taotao_manager_web\\src\\main\\resources\\client.conf");
        String uploadFile = client.uploadFile("F:\\alignment_1.jpg","jpg");
        System.out.println(uploadFile);
    }

}
