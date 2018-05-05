package ru.vachok.ftpplus.feat;



import org.apache.commons.io.FileUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;

import static ru.vachok.ftpplus.Const.LOGGER;

/**
 Шифруем/Дешифруем

 @since 05.05.2018 (15:45) */
public class PassClass {

    public static void decryptPass(String myPass) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher aesCipDecrypt = Cipher.getInstance("AES");
        byte[] myPassBytes = myPass.getBytes();
        File keyFile = new File("key.cip");
        Key keyFromFile = new SecretKeySpec(FileUtils.readFileToByteArray(keyFile), "AES");
        aesCipDecrypt.init(Cipher.DECRYPT_MODE, keyFromFile);
        aesCipDecrypt.doFinal(myPassBytes);
        byte[] decrMyPassBytes = aesCipDecrypt.doFinal(myPassBytes);
        StringBuilder passDec = new StringBuilder();
        for (byte b : decrMyPassBytes) {
            passDec.append((char) b);
        }
        LOGGER.log(Level.WARNING, () -> passDec + " is password | " + "DSMySQL.java ID == 49 ||");
    }
}