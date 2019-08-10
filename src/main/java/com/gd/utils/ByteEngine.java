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


public class ByteEngine {
    
    public static int find(byte[] source, byte[] match) {
        if(match.length == 1)
            return findByte(source,match[0]);
        else
            return findArrays(source,match);
    }

    private static int findByte(byte[] source, byte match) {
        if(source == null)
            return -1;
        if(source.length == 0)
            return -1;
        for(int spos=0; spos < source.length; spos++) {
            if(match == source[spos])
                return spos;
        }
        return -1;
    }
   
    private static int findArrays(byte[] source, byte[] match) {
        if(source == null || match == null)
            return -1;
        if(source.length == 0 || match.length == 0)
            return -1;
        int ret = -1;
        int mpos = 0;
        byte m = match[mpos];
        for(int spos = 0 ; spos < source.length; spos++) {
            if(m == source[spos]) {
                // starting match
                if(mpos == 0)
                    ret = spos;
                // finishing match
                else if(mpos == match.length - 1)
                    return ret;
                mpos++;
                m = match[mpos];
            }
        else {
            ret = -1;
            mpos = 0;
            m = match[mpos];
        }
    }
    return ret;
  }
    
    public static byte[] splitByteArray (byte[] src, int srcPos, int endSrcPos) {
        int length = (endSrcPos - srcPos) + 1;
        byte[] dest = new byte[length];
        System.arraycopy(src, srcPos, dest, 0, length);
        return dest;
    }
    
}
