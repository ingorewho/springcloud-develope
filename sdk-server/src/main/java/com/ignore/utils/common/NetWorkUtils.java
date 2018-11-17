package com.ignore.utils.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 17:11 2018/11/17
 */
public class NetWorkUtils {
    private static final Logger logger = LogManager.getLogger();

    private NetWorkUtils(){}
    /**
     * 获取到 SessionID
     * @param request HttpServletRequest
     * @return SessionID
     */
    public static String getSessionID(HttpServletRequest request) {
        return request.getSession().getId();
    }



    /**
     * 获取得到本机IP地址
     */
    public static String getLocalIP() {
        if (isWindowsOS()) {
            return getWindowsIP();
        } else {
            return getLinuxLocalIp();
        }
    }

    /**
     * 判断操作系统是否为windows系统
     */
    public static boolean isWindowsOS() {
        boolean isWindowsOS = false;
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().indexOf("windows") > -1) {
            isWindowsOS = true;
        }
        return isWindowsOS;
    }

    /**
     * 获取到Host名字
     */
    public static String getLocalHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    /**
     *获取WindowsIP
     */
    public static String getWindowsIP() {
        StringBuilder serverIP = new StringBuilder();
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
            byte[] ipAddr = addr.getAddress();
            for (int i = 0; i < ipAddr.length; i++) {
                if (i > 0) {
                    serverIP.append('.');
                }
                serverIP.append(ipAddr[i] & 0xFF);
            }
        } catch (UnknownHostException e) {
            logger.error(e.getMessage());
        }
        return serverIP.toString();
    }

    /**
     * 获取LinuxIp
     */
    private static String getLinuxLocalIp() {
        String ip = "";
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                String name = intf.getName();
                if(name.contains("docker") || name.contains("lo")){
                    continue;
                }
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (inetAddress.isLoopbackAddress()) {
                        continue;
                    }
                    String ipaddress = inetAddress.getHostAddress();
                    if (!ipaddress.contains("::") && !ipaddress.contains("0:0:")
                            && !ipaddress.contains("fe80")) {
                        ip = ipaddress;
                    }
                }
            }

        } catch (Exception ex) {
            ip = "127.0.0.1";
            logger.error(ex.getMessage());
        }
        return ip;
    }
}
