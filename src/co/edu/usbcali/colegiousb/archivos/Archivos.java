package co.edu.usbcali.colegiousb.archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Archivos implements IArchivos {

    @Override
    public void crearArchivo(String ruta) throws Exception {
        try {
            File archivo = new File(ruta);
            archivo.createNewFile();

        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public void adicionarLineaInicio(String ruta, String linea) throws Exception {

        try {
            File archivo = new File(ruta);

            String contenidoTotal = linea + "\n";

            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            String LineaLeida = "";
            while ((LineaLeida = br.readLine()) != null) {
                contenidoTotal = contenidoTotal + LineaLeida + "\n";
            }
            br.close();
            fr.close();

            reemplazarContenidodeArchivo(ruta, contenidoTotal);

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void adicionarLineaFinal(String ruta, String linea) throws Exception {
        try {
            File archivo = new File(ruta);

            String contenidoTotal = "";

            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            String LineaLeida = "";
            while ((LineaLeida = br.readLine()) != null) {
                contenidoTotal = contenidoTotal + LineaLeida + "\n";
            }
            contenidoTotal = contenidoTotal + linea + "\n";
            br.close();
            fr.close();

            reemplazarContenidodeArchivo(ruta, contenidoTotal);

        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public void adicionarLineaenNumero(String ruta, String linea, int numero) throws Exception {
        try {
            int contadorLinea = 0;
            File archivo = new File(ruta);

            String contenidoTotal = "";

            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            String LineaLeida = "";
            while ((LineaLeida = br.readLine()) != null) {
                contenidoTotal = contenidoTotal + LineaLeida + "\n";
                contadorLinea++;
                if (contadorLinea == (numero - 1)) {
                    contenidoTotal = contenidoTotal + linea + "\n";
                }
            }
            br.close();
            fr.close();

            reemplazarContenidodeArchivo(ruta, contenidoTotal);

        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public int[] buscarNumerosdeLineaconPalabraCaseSensitive(String ruta, String palabra) throws Exception {
        int lineas[] = null;
        try {
            File archivo = new File(ruta);

            int numeroLineasConPalabra = 0;
            String LineaLeida;
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while ((LineaLeida = br.readLine()) != null) {
                if (LineaLeida.indexOf(palabra) >= 0) {
                    numeroLineasConPalabra++;
                }

            }
            br.close();
            fr.close();
            lineas = new int[numeroLineasConPalabra];
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            int contadorLineasConPalabra = 0;
            int contadorLineasConPalabra2 = 0;
            while ((LineaLeida = br.readLine()) != null) {
                contadorLineasConPalabra2++;
                if (LineaLeida.indexOf(palabra) >= 0) {
                    lineas[contadorLineasConPalabra] = contadorLineasConPalabra2;
                    contadorLineasConPalabra++;
                }

            }
            br.close();
            fr.close();

        } catch (Exception e) {
            throw e;
        }



        return lineas;
    }

    @Override
    public int[] buscarNumerosdeLineaconPalabaCaseInsensitive(String ruta, String palabra) throws Exception {
        int lineas[] = null;
        try {
            palabra = palabra.toUpperCase();
            File archivo = new File(ruta);

            int numeroLineasConPalabra = 0;
            String LineaLeida;
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while ((LineaLeida = br.readLine()) != null) {
                LineaLeida = LineaLeida.toUpperCase();
                if (LineaLeida.indexOf(palabra) >= 0) {
                    numeroLineasConPalabra++;
                }

            }
            br.close();
            fr.close();
            lineas = new int[numeroLineasConPalabra];
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            int contadorLineasConPalabra = 0;
            int contadorLineasConPalabra2 = 0;
            while ((LineaLeida = br.readLine()) != null) {
                contadorLineasConPalabra2++;
                LineaLeida = LineaLeida.toUpperCase();
                if (LineaLeida.indexOf(palabra) >= 0) {
                    lineas[contadorLineasConPalabra] = contadorLineasConPalabra2;
                    contadorLineasConPalabra++;
                }

            }
            br.close();
            fr.close();

        } catch (Exception e) {
            throw e;
        }



        return lineas;
    }

    @Override
    public int contarNumeroOcurrenciasdePalabraCaseSensitive(String ruta, String palabra) throws Exception {
        int contadorPalabrasEncontradas = 0;
        try {
            File archivo = new File(ruta);

            String LineaLeida;
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while ((LineaLeida = br.readLine()) != null) {

                int indiceEncontrado = -1;
                do {
                    if (indiceEncontrado == -1) {
                        if ((indiceEncontrado = LineaLeida.indexOf(palabra)) >= 0) {
                            contadorPalabrasEncontradas++;
                        }
                    } else {
                        if ((indiceEncontrado = LineaLeida.indexOf(palabra, indiceEncontrado + palabra.length())) >= 0) {
                            contadorPalabrasEncontradas++;
                        }
                    }
                } while (indiceEncontrado >= 0);

            }

            br.close();
            fr.close();
        } catch (Exception e) {
            throw e;
        }
        return contadorPalabrasEncontradas;
    }

    @Override
    public int contarNumeroOcurrenciasdePalabraCaseInsensitive(String ruta, String palabra) throws Exception {
        int contadorPalabrasEncontradas = 0;
        try {
            palabra = palabra.toUpperCase();
            File archivo = new File(ruta);
            if ((!archivo.exists())) {
                archivo.createNewFile();
            }
            String LineaLeida;
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while ((LineaLeida = br.readLine()) != null) {
                LineaLeida = LineaLeida.toUpperCase();
                int indiceEncontrado = -1;
                do {
                    if (indiceEncontrado == -1) {
                        if ((indiceEncontrado = LineaLeida.indexOf(palabra)) >= 0) {
                            contadorPalabrasEncontradas++;
                        }
                    } else {
                        if ((indiceEncontrado = LineaLeida.indexOf(palabra, indiceEncontrado + palabra.length())) >= 0) {
                            contadorPalabrasEncontradas++;
                        }
                    }
                } while (indiceEncontrado >= 0);

            }

            br.close();
            fr.close();
        } catch (Exception e) {
            throw e;
        }
        return contadorPalabrasEncontradas;

    }

    @Override
    public void eliminarLineaInicio(String ruta) throws Exception {
        try {
            int c = 0;
            File archivo = new File(ruta);

            String contenidoTotal = "";

            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            String LineaLeida = "";
            while ((LineaLeida = br.readLine()) != null) {
                contenidoTotal = contenidoTotal + LineaLeida + "\n";
                c++;
                if (c == 1) {
                    contenidoTotal = "";
                }
            }
            br.close();
            fr.close();

            reemplazarContenidodeArchivo(ruta, contenidoTotal);

        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public void eliminarLineaFinal(String ruta) throws Exception {
        try {
            int c = 0;
            int c2 = 0;
            File archivo = new File(ruta);

            String contenidoTotal = "";

            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            String LineaLeida = "";
            while ((LineaLeida = br.readLine()) != null) {
                c++;
            }
            br.close();
            fr.close();

            fr = new FileReader(ruta);
            br = new BufferedReader(fr);

            while ((LineaLeida = br.readLine()) != null) {
                c2++;
                if (c2 < c) {
                    contenidoTotal = contenidoTotal + LineaLeida + "\n";
                }
            }
            br.close();
            fr.close();

            reemplazarContenidodeArchivo(ruta, contenidoTotal);

        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public void eliminarNumerodeLinea(String ruta, int numero) throws Exception {
        try {
            int c = 0;
            int c2 = 0;
            File archivo = new File(ruta);

            String contenidoTotal = "";

            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            String LineaLeida = "";
            while ((LineaLeida = br.readLine()) != null) {
                c++;
            }
            br.close();
            fr.close();

            fr = new FileReader(ruta);
            br = new BufferedReader(fr);

            while ((LineaLeida = br.readLine()) != null) {
                c2++;
                if (c2 < (numero)) {
                    contenidoTotal = contenidoTotal + LineaLeida + "\n";
                }
                if (c2 > numero) {
                    contenidoTotal = contenidoTotal + LineaLeida + "\n";
                }

            }
            br.close();
            fr.close();

            reemplazarContenidodeArchivo(ruta, contenidoTotal);

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void eliminarContenidoArchivo(String ruta) throws Exception {
        try {

            File archivo = new File(ruta);

            String contenidoTotal = "";

            reemplazarContenidodeArchivo(ruta, contenidoTotal);

        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public void eliminarOcurrenciasdePalabraCaseSensitive(String ruta, String palabra) throws Exception {
        String contenidoTotal = "";
        try {
            File archivo = new File(ruta);

            String LineaLeida;
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while ((LineaLeida = br.readLine()) != null) {
                int indiceEncontrado = -1;
                do {
                    if (indiceEncontrado == -1) {
                        if ((indiceEncontrado = LineaLeida.indexOf(palabra)) >= 0) {
                            LineaLeida = LineaLeida.replaceAll(palabra, "");
                        }
                    } else {
                        if ((indiceEncontrado = LineaLeida.indexOf(palabra, indiceEncontrado + palabra.length())) >= 0) {
                            LineaLeida = LineaLeida.replaceAll(palabra, "");
                        }
                    }

                } while (indiceEncontrado >= 0);
                contenidoTotal = contenidoTotal + LineaLeida + "\n";
            }
            reemplazarContenidodeArchivo(ruta, contenidoTotal);

            br.close();
            fr.close();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void eliminarOcurrenciasdePalabraCaseInsensitive(String ruta, String palabra) throws Exception {
        String reemplazo = "";
        String contenidoTotal = "";
        try {
            File archivo = new File(ruta);

            String LineaLeida;
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while ((LineaLeida = br.readLine()) != null) {
                reemplazo = LineaLeida.toUpperCase();
                palabra = palabra.toUpperCase();
                int indiceEncontrado = -1;


                do {
                    if (indiceEncontrado == -1) {
                        if ((indiceEncontrado = reemplazo.indexOf(palabra)) >= 0) {
                            LineaLeida = LineaLeida.substring(0, indiceEncontrado) + LineaLeida.substring(palabra.length());
//							LineaLeida=LineaLeida.substring(0, indiceEncontrado) + "";
                        }
                    } else {
                        if ((indiceEncontrado = reemplazo.indexOf(palabra, indiceEncontrado + palabra.length())) >= 0) {
//							LineaLeida=LineaLeida + LineaLeida.substring(palabra.length());
                        }
                    }

                } while (indiceEncontrado >= 0);
                contenidoTotal = contenidoTotal + LineaLeida + "\n";
            }
            reemplazarContenidodeArchivo(ruta, contenidoTotal);

            br.close();
            fr.close();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void eliminarArchivo(String ruta) throws Exception {
        try {
            File archivo = new File(ruta);
            archivo.delete();
        } catch (Exception e) {
            throw e;

        }
    }

    @Override
    public void reemplazarContenidodeArchivo(String ruta, String contenido) throws Exception {

        try {
            File archivo = new File(ruta);

            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);

            bw.close();
            fw.close();


        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public String obtenerContenidodeArchivo(String ruta) throws Exception {
        String ContenidoTotal = "";
        try {
            File archivo = new File(ruta);


            String LineaLeida = "";
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while ((LineaLeida = br.readLine()) != null) {
                ContenidoTotal = ContenidoTotal + LineaLeida + "\n";

            }
            br.close();
            fr.close();


        } catch (Exception e) {
            throw e;
        }



        return ContenidoTotal;
    }

    @Override
    public String obtenerLinea(String ruta) throws Exception {
        String Linea = "";
        try {
            File archivo = new File(ruta);

            String LineaLeida = "";
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            if ((LineaLeida = br.readLine()) != null) {
                Linea = LineaLeida;

            }
            br.close();
            fr.close();


        } catch (Exception e) {
            throw e;
        }



        return Linea;
    }

    @Override
    public int obtenerNumerodeLineas(String ruta) throws Exception {
        int NumeroLineas = 0;
        try {
            File archivo = new File(ruta);


            String LineaLeida = "";
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while ((LineaLeida = br.readLine()) != null) {
                NumeroLineas++;
            }
            br.close();
            fr.close();


        } catch (Exception e) {
            throw e;
        }



        return NumeroLineas;
    }
}
