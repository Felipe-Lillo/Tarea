package Utils;

import java.io.File;

public class RevisionDocumentosTmp {
    public static boolean eliminarArchivoExistente(String nombreArchivo){
        File archivo = new File(ReadProperties.readFromConfig("Properties.properties").getProperty("rutaCarpetaTxt"));
        String[] RevisarArchivo = archivo.list();
        try{
            for (int j = 0; j < RevisarArchivo.length; j++) {
                if (RevisarArchivo[j].equals(nombreArchivo)) {
                    File archivos = new File(ReadProperties.readFromConfig("Properties.properties").getProperty("rutaCarpetaTxt") + "\\" + nombreArchivo);
                    archivos.delete();
                    System.out.println("Archivo Eliminado");
                    return true;
                }
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public static boolean limpiarCarpeta(String nombreCarpeta){
        File archivo = new File(ReadProperties.readFromConfig("Properties.properties").getProperty("rutaCapertaImagenes") + "\\" + nombreCarpeta);
        File[] revisarArchivo = archivo.listFiles();
        try{
            for (int x = 0; x < revisarArchivo.length; x++) {
                revisarArchivo[x].delete();
                if(revisarArchivo == null){
                    return true;
                }
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        /*if (RevisarArchivo.equals(nombreCarpeta)) {
            File archivos = new File(ReadProperties.readFromConfig("Properties.properties").getProperty("rutaCarpetaImagenes") + "\\" + nombreCarpeta);
            archivos.delete();
            System.out.println("Carpeta limpia");
            return true;
        }else{
            System.out.println("La carpeta no existe");
            return false;
        }*/
    }
}
