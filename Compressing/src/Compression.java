import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;

public class Compression  extends Frame{

	public static  void zip(BufferedImage image,File jpegFiletoSave, double quality ) throws IOException {
		ImageWriter jpgwriter=ImageIO.getImageWritersByFormatName("jpg").next();
		ImageWriteParam jpgWriteParam = jpgwriter.getDefaultWriteParam();
		jpgWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		jpgWriteParam.setCompressionQuality((float) quality);

		
		jpgwriter.setOutput(ImageIO.createImageOutputStream(jpegFiletoSave));
		IIOImage outputImage = new IIOImage(image, null, null);
		jpgwriter.write(null, outputImage, jpgWriteParam);
		jpgwriter.dispose();
		}
	public Compression() {
		// TODO Auto-generated constructor stub
	}

}
