package co.edu.usbcali.colegiousb.archivos;

public interface IArchivos {
    public void crearArchivo(String ruta) throws Exception;
    public void adicionarLineaInicio(String ruta, String linea) throws Exception;
    public void adicionarLineaFinal(String ruta, String linea) throws Exception;
    public void adicionarLineaenNumero(String ruta, String linea, int numero) throws Exception;
    public int[] buscarNumerosdeLineaconPalabraCaseSensitive(String ruta, String palabra) throws Exception;
    public int[] buscarNumerosdeLineaconPalabaCaseInsensitive(String ruta, String palabra) throws Exception;
    public int contarNumeroOcurrenciasdePalabraCaseSensitive(String ruta, String palabra) throws Exception;
    public int contarNumeroOcurrenciasdePalabraCaseInsensitive(String ruta, String palabra) throws Exception;
    public void eliminarLineaInicio(String ruta) throws Exception;
    public void eliminarLineaFinal(String ruta) throws Exception;
    public void eliminarNumerodeLinea(String ruta, int numero) throws Exception;
    public void eliminarContenidoArchivo(String ruta) throws Exception;
    public void eliminarOcurrenciasdePalabraCaseSensitive(String ruta, String palabra) throws Exception;
    public void eliminarOcurrenciasdePalabraCaseInsensitive(String ruta, String palabra) throws Exception;
    public void eliminarArchivo(String ruta) throws Exception;
    public void reemplazarContenidodeArchivo(String ruta, String contenido) throws Exception;
    public String obtenerContenidodeArchivo(String ruta) throws Exception;
    public String obtenerLinea(String ruta) throws Exception;
    public int obtenerNumerodeLineas(String ruta) throws Exception;
}
