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

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Julio
 */
public class ImageUtil {

    public static byte[] resizeImage(byte[] img, int x, int y) throws IOException {
        InputStream in = new ByteArrayInputStream(img);
        BufferedImage srcImage = ImageIO.read(in);
        int type = srcImage.getType() == 0 ? BufferedImage.TYPE_BYTE_BINARY : srcImage.getType();
	BufferedImage destImage = new BufferedImage(x, y, type);
	Graphics2D g = destImage.createGraphics();        
	g.drawImage(srcImage.getScaledInstance(x, y, Image.SCALE_SMOOTH), 0, 0, x, y, null);
	g.dispose();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write( destImage, "jpg", baos );
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        baos.close();
	return imageInByte;
    }
    
    /**
     * Guarda una imagen en formato jpg a partir de un arreglo de bytes de una
     * imagen, especificando la ruta a través del String fi
     * @param imageByte
     * @param fi
     * @throws IOException 
     */
    public static void saveImageJPG (byte[] imageByte, String fi) throws IOException {
        if(imageByte!=null||imageByte.length!=0) {
            File f = new File(fi);
            ImageIcon icon = new ImageIcon(imageByte);
            Image img = icon.getImage();
            BufferedImage bi = new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = bi.createGraphics();
            g2.drawImage(img, 0, 0, null);
            g2.dispose();
            ImageIO.write(bi, "jpg", f);
            System.out.println(f.getAbsolutePath());
        }
    }
    
    public static void saveImageJPG(Image img, String fi) throws IOException {
        File f = new File(fi);
        BufferedImage bi = new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = bi.createGraphics();
        g2.drawImage(img, 0, 0, null);
        g2.dispose();
        ImageIO.write(bi, "jpg", f);
    }

}