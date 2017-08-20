package com.zghw.imitate.java.net;

import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by zhanghongwei on 2017/8/19.
 */
public class InetAddressExample {
    public static void main(String args[]){
        try {
            //NetworkInterface虚拟网络接口类,具体实现使用了native方法.
            Enumeration<NetworkInterface>  networkInterfaceEnumeration = NetworkInterface.getNetworkInterfaces();
            while(networkInterfaceEnumeration.hasMoreElements()){
                NetworkInterface networkInterface=networkInterfaceEnumeration.nextElement();
                String displayName=networkInterface.getDisplayName();
                byte[] hardwareAddress = networkInterface.getHardwareAddress();
                int index = networkInterface.getIndex();
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                List<InterfaceAddress> interfaceAddresses =networkInterface.getInterfaceAddresses();
                int mtu = networkInterface.getMTU();
                String name = networkInterface.getName();
                NetworkInterface parent = networkInterface.getParent();
                Enumeration<NetworkInterface> subInterfaces = networkInterface.getSubInterfaces();
                boolean loopback = networkInterface.isLoopback();
                boolean pointToPoint = networkInterface.isPointToPoint();
                boolean up = networkInterface.isUp();
                boolean virtual = networkInterface.isVirtual();
                boolean supportsMulticast = networkInterface.supportsMulticast();
                System.out.println("displayName:"+displayName);
                if(hardwareAddress!=null){
                    System.out.println("hardwareAddress:"+new String(hardwareAddress,"ISO-8859-1"));
                }
                System.out.println("index:"+index);
                System.out.println("mtu:"+mtu);
                System.out.println("name:"+name);
                System.out.println("loopback:"+loopback);
                System.out.println("pointToPoint:"+pointToPoint);
                System.out.println("virtual:"+virtual);
                System.out.println("supportsMulticast:"+supportsMulticast);
                System.out.println("===========================================================================");
                while(inetAddresses.hasMoreElements()){
                    InetAddress inetAddress = inetAddresses.nextElement();
                    showInetAddressInfo(inetAddress);
                }

            }
            InetAddress byNameInetAddress = InetAddress.getByName("119.75.216.20");
            System.out.println("=================================byNameInetAddress========================================");
            showInetAddressInfo(byNameInetAddress);
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("=================================localHost========================================");
            showInetAddressInfo(localHost);
            InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
            System.out.println("=================================loopbackAddress========================================");
            showInetAddressInfo(loopbackAddress);
            byte[] addr = new byte[]{(byte)127,(byte)0,(byte)0,(byte)1};
            InetAddress byAddress = InetAddress.getByAddress(addr);
            System.out.println("=================================byAddress========================================");
            showInetAddressInfo(byAddress);
            InetAddress baiduInetAddress = InetAddress.getByName("www.baidu.com");
            System.out.println("=================================baiduInetAddress========================================");
            showInetAddressInfo(baiduInetAddress);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }

    private static void showInetAddressInfo(InetAddress inetAddress) {
        byte[] address = inetAddress.getAddress();
        StringBuilder addressSb=new StringBuilder();
        for(byte addr : address){
            int b=new Integer(addr);
            addressSb.append(b<0?b+256:b);
            addressSb.append(" ");
        }
        System.out.println("address:"+addressSb);
        String canonicalHostName = inetAddress.getCanonicalHostName();
        System.out.println("canonicalHostName:"+canonicalHostName);
        String hostAddress = inetAddress.getHostAddress();
        System.out.println("hostAddress:"+hostAddress);
        String hostName = inetAddress.getHostName();
        System.out.println("hostName:"+hostName);
        boolean anyLocalAddress = inetAddress.isAnyLocalAddress();
        System.out.println("anyLocalAddress:"+anyLocalAddress);
        boolean linkLocalAddress = inetAddress.isLinkLocalAddress();
        System.out.println("linkLocalAddress:"+linkLocalAddress);
        boolean loopbackAddress = inetAddress.isLoopbackAddress();
        System.out.println("loopbackAddress:"+loopbackAddress);
        boolean mcGlobal = inetAddress.isMCGlobal();
        System.out.println("mcGlobal:"+mcGlobal);
        boolean mcLinkLocal = inetAddress.isMCLinkLocal();
        System.out.println("mcLinkLocal:"+mcLinkLocal);
        boolean mcNodeLocal = inetAddress.isMCNodeLocal();

        boolean mcOrgLocal = inetAddress.isMCOrgLocal();
        boolean mcSiteLocal = inetAddress.isMCSiteLocal();
        boolean multicastAddress = inetAddress.isMulticastAddress();
        boolean siteLocalAddress = inetAddress.isSiteLocalAddress();

        System.out.println("mcNodeLocal:"+mcNodeLocal);
        System.out.println("mcOrgLocal:"+mcOrgLocal);
        System.out.println("mcSiteLocal:"+mcSiteLocal);
        System.out.println("multicastAddress:"+multicastAddress);
        System.out.println("siteLocalAddress:"+siteLocalAddress);
    }
}
