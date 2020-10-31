package com.company;

import java.util.LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: 推荐结果打散
 * @description:
 * @author: Mr.Huang
 * @create: 2020-10-27 16:07
 **/
public class KuaiShouEx {
    public static void main(String[] args) {
        List<String> picAndVideoList = new ArrayList<>();
        picAndVideoList.add("v_0");
        picAndVideoList.add("v_1");
        picAndVideoList.add("v_2");
        picAndVideoList.add("p_3");
        picAndVideoList.add("p_4");
        picAndVideoList.add("p_5");
        picAndVideoList.add("v_6");
        picAndVideoList.add("p_7");
        picAndVideoList.add("v_8");
        picAndVideoList.add("v_9");
        picAndVideoList.add("v_10");
        List<String> result = new KuaiShouEx().getRecommendeResult(picAndVideoList, 2);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public List<String> getRecommendeResult(List<String> picAndVideo, int maxInterval) {
        List<String> result = new ArrayList<>();
        LinkedList<String> videoQueue = new LinkedList();
        LinkedList<String> picQueue = new LinkedList();
        boolean isPic = false;
        int index = 0;
        if (picAndVideo == null || picAndVideo.size() == 0) {
            return result;
        }
        while (!isPic && index < picAndVideo.size()) {
            if (isVideo(picAndVideo.get(index))) {
                result.add(picAndVideo.get(index));
                index++;
            } else {
                isPic = true;
            }
        }
        while (index < picAndVideo.size()) {
            if (isVideo(picAndVideo.get(index))) {
                videoQueue.add(picAndVideo.get(index));
            } else {
                picQueue.add(picAndVideo.get(index));
            }
            index++;
        }
        int currentSize = result.size();
        while (!videoQueue.isEmpty() && !picQueue.isEmpty()) {
            if (currentSize >= maxInterval) {
                result.add(picQueue.poll());
                currentSize = 0;
            } else {
                result.add(videoQueue.poll());
                currentSize++;
            }
        }
        while (!videoQueue.isEmpty()) {
            result.add(videoQueue.poll());
        }
        if (currentSize >= maxInterval && !picQueue.isEmpty()) {
            result.add(picQueue.poll());
        }
        return result;
    }

    private boolean isVideo(String str) {
        if (str.indexOf("v") != -1) {
            return true;
        }
        return false;
    }
}
