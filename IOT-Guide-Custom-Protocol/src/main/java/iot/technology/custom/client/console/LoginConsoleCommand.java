package iot.technology.custom.client.console;

import io.netty.channel.Channel;
import iot.technology.custom.protocol.request.LoginRequestPacket;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * @author james mu
 * @date 2020/8/10 17:35
 */
@Slf4j
public class LoginConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();

        log.info("输入设备Id登录: ");
        loginRequestPacket.setClientId(scanner.nextLine());
        loginRequestPacket.setPassword("IoT Technology Guide");

        //发送登录包
        channel.writeAndFlush(loginRequestPacket);
        waitForLoginResponse();
    }

    private static void waitForLoginResponse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
