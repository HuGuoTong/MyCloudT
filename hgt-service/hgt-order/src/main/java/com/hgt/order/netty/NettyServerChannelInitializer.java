package com.hgt.order.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @Author: HGT
 * @Description: 服务端初始化，客户端与服务器端连接一旦创建，这个类中方法就会被回调，
 * 设置出站编码器和入站解码器
 * @Date: 2021/8/18 16:53
 * @Version: 1.0
 */
public class NettyServerChannelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {

//        channel.pipeline().addLast("decoder",new StringDecoder(CharsetUtil.UTF_8));
//        channel.pipeline().addLast("encoder",new StringEncoder(CharsetUtil.UTF_8));
        // websocket基于http协议，需要有http的编解码器
        channel.pipeline().addLast(new HttpServerCodec());
        channel.pipeline().addLast(new NettyServerHandler());
    }
}
