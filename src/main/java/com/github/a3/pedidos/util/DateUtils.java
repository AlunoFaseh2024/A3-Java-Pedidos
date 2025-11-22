package com.github.a3.pedidos.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DateUtils {
    public static String formatar(LocalDateTime dataHora) {
        return dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
}
