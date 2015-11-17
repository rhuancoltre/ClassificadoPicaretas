package br.grupointegrado.ads.picaretas.util;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Rhuan Coltre
 */
public class Util {

    public static int stringParaInt(String valor) {
        try {
            return Integer.parseInt(valor);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }
    private static SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");

    public static Date stringParaData(String data) {
        try {
            return formataData.parse(data);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Convete Data para String no formato dd/MM/yyyy
     *
     * @param data
     * @return
     */
    public static String dataParaString(Date data) {

        if (data == null) {
            return "";
        }
        return formataData.format(data);
    }

    /**
     * Converte String para Double
     *
     * @param valor
     * @return
     */
    public static double stringParaDouble(String valor) {
        try {
            return Double.parseDouble(valor);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    /**
     * Converte a Data do tipo java.Util.Date para java.sql.Date
     *
     * @param data
     * @return
     */
    public static java.sql.Date dateParaSQL(Date data) {
        try {
            long milisegundos = data.getTime();
            java.sql.Date sqlDate = new java.sql.Date(milisegundos);
            return sqlDate;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Converte Objeto Date para TimeStamp
     *
     * @param data
     * @return
     */
    public static Timestamp dataParaTimeStamp(Date data) {
        try {
            long milisegundos = data.getTime();
            Timestamp time = new Timestamp(data.getTime());
            return time;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private static DecimalFormat decimalFormat = new DecimalFormat("#,###,###,##0.00");
            
    public static String doubleParaString(double valor) {
        return decimalFormat.format(valor);
    }
    
    private static SimpleDateFormat formataDataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    
    public static String dataHoraParaString(Date dataHora) {
        return formataDataHora.format(dataHora);
    }

}
