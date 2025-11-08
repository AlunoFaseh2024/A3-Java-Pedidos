package com.github.a3.pedidos.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class CodigoEntregaGenerator {
    public static String gerarCodigo() {
        return String.valueOf(100000 + new Random().nextInt(900000));
    }
}