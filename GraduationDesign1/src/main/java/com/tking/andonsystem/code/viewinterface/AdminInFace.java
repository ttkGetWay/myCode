package com.tking.andonsystem.code.viewinterface;

import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

import java.util.Date;

public interface AdminInFace {

    /**
     * 发送消息按钮
     *
     * @param userName 用户账号
     * @param talkId   对话框账号（好友账号/群组名称）
     * @param talkType 对话框类型：0好友、1群组
     * @param msg      发送消息内容
     * @param msgType  发送消息类型：0文字消息、1图片
     * @param msgDate  发送消息时间
     */
    void sendMsg(String userName, String talkId, Integer talkType, String msg, Integer msgType, Date msgDate);

    /**
     * 事件处理；开启与好友发送消息 [点击发送消息时候触发 -> 添加到对话框、选中、展示对话列表]
     *
     * @param userName       用户账号
     * @param userFriendName 好友账号
     */
    void eventAddTalkUser(String userName, String userFriendName);

    /**
     * 事件处理；删除指定对话框
     *
     * @param userName 用户ID
     * @param talkId 对话框ID
     */
    void eventDelTalkUser(String userName, String talkId);

    /**
     * 事件处理；查询有缘用户添加到列表
     *
     * @param userName   用户ID
     * @param listView 用户列表[非必需使用，同步接口可使用]
     */
    void addFriendLuck(String userName, ListView<Pane> listView);

//    void addFriendLuck(String userName, ListView<Pane> listView);

    /**
     * 事件处理；好友搜索[搜索后结果调用添加：addLuckFriend]
     *
     * @param userName 用户ID
     * @param text   搜索关键字
     */
    void friendLuckSearch(String userName, String text);

    /**
     * 添加好友事件
     *
     * @param userName   个人ID
     * @param friendName 好友ID
     */
    void eventAddLuckUser(String userName, String friendName);

}
