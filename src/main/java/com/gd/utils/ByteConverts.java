/* 
 * Version 2.0 Revision 1
 * 
 * 01/03/2014
 *
 * Copyright 2013-2019 gigaDatta, S.A.
 * Julio Francisco Chinchilla Valenzuela - gigadatta@gmail.com
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */

package com.gd.utils;

/**
 *
 * @author Julio
 */
public class ByteConverts {
    
     public static String byteToASCII (byte[] data) {
        StringBuilder localStringBuffer = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            localStringBuffer.append((char)(data[i] & 0xFF));
        }
        return localStringBuffer.toString();
    }
    
    public static String byteToASCII (byte[] data, int init, int end) {
        StringBuilder localStringBuffer = new StringBuilder(); 
        for (int i = init; i <= end; i++) {
            localStringBuffer.append((char)(data[i] & 0xFF));
        }
        return localStringBuffer.toString();
    }
    
    public static String byteToINT (byte[] data, int init, int end) {
        StringBuilder localStringBuffer = new StringBuilder(); 
        for (int i = init; i <= end; i++) {
            localStringBuffer.append((int)(data[i] & 0xFF));
        }
        return localStringBuffer.toString();
    }
    
    public static int byteToInteger(byte[] data) {        
        return Integer.valueOf(byteToHex(data).replace(" ",""),(byte)0x10).intValue();
    }
    
    public static String byteToHex(byte[] data)  {
        StringBuilder localStringBuilder = new StringBuilder();
        for (int i = 0; i < data.length; i++)  {
            String str;
            if ((str=Integer.toHexString(data[i]&0xFF).toUpperCase()).length()==1) {
                localStringBuilder.append(0);
            }
        localStringBuilder.append(str).append(" ");
        }
        return localStringBuilder.substring(0, localStringBuilder.length() - 1);
    }
    
    public static String byteToHex(byte[] data, int init, int end) {
        StringBuilder localStringBuilder = new StringBuilder();
        for (int i = init; i <= end; i++)  {
            String str;
            if ((str=Integer.toHexString(data[i]&0xFF).toUpperCase()).length()==1) {
                localStringBuilder.append(0);
            }
        localStringBuilder.append(str).append(" ");
        }
        return localStringBuilder.substring(0, localStringBuilder.length() - 1);
    }
    
    public static byte[] hexStringToByteArray(String s) {
        s = s.replaceAll("\\s","");
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                             + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
    
    public static String parsingAsciiData (byte[] data, int i, int j) {
        byte[] parsingBytes = new byte[j-i];
        System.arraycopy(data, i, parsingBytes, 0, j-i);
        return ByteConverts.byteToASCII(parsingBytes);
    }
    
    public static int parsingIntegerData (byte[] data, int i, int j) {
        byte[] parsingBytes = new byte[j-i];
        System.arraycopy(data, i, parsingBytes, 0, j-i);
        return ByteConverts.byteToInteger(parsingBytes);
    }
    
}
