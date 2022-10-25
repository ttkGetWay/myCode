//package com.tking.andonsystem.quartz.config;
//
//import com.tking.andonsystem.quartz.QuartzJob;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.quartz.JobDetailFactoryBean;
//import org.springframework.scheduling.quartz.SchedulerFactoryBean;
//import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
//
///**
// * Quartz配置类
// */
//@Configuration
//public class QuartzConfig {
//    /**
//     * 首先创建Job对象
//     */
//    @Bean
//    public JobDetailFactoryBean jobDetailFactoryBean() {
//        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
//        //关联自己写的Job类
//        factoryBean.setJobClass(QuartzJob.class);
//        return factoryBean;
//    }
//
//    /**
//     * 创建Trigger
//     * 一个简单的trigger
//     */
//    @Bean
//    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
//        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
//        //关联JobDetail对象
//        factoryBean.setJobDetail(jobDetailFactoryBean.getObject());
//        //执行毫秒数,为2毫秒
//        factoryBean.setRepeatInterval(2000);
//
//        //也可以设置执行次数
////        factoryBean.setRepeatCount(5);
//        return factoryBean;
//    }
//
//    /**
//     *  创建SchedulerFactoryBean
//     */
//    @Bean
//    public SchedulerFactoryBean schedulerFactoryBean(SimpleTriggerFactoryBean simpleTriggerFactoryBean) {
//        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
//        //关联trigger
//        schedulerFactoryBean.setTriggers(simpleTriggerFactoryBean.getObject());
//        return schedulerFactoryBean;
//    }
//}
