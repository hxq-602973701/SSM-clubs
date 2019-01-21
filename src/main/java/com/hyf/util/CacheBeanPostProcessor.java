package com.hyf.util;

import com.hyf.entity.News;
import com.hyf.service.LinkService;
import com.hyf.service.NewsService;
import com.hyf.service.NewsTypeService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Spring全局加载器
 */
public class CacheBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessAfterInitialization(Object obj, String arg1) throws BeansException {
        News news = new News();
        try {
            if (obj instanceof NewsTypeService) {
                ((NewsTypeService) obj).selectByNewsType(news);//加载栏目数据
            } else if (obj instanceof NewsService) {
                ((NewsService) obj).selectByCurrent(news);//加载最近新闻数据
                ((NewsService) obj).selectByClick(news);//加载点击新闻数据
            } else if (obj instanceof LinkService) {
                ((LinkService) obj).selectAll();//加载友情链接数据
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }


    @Override
    public Object postProcessBeforeInitialization(Object arg0, String arg1)
            throws BeansException {
        // TODO Auto-generated method stub
        return arg0;
    }

}