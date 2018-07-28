
package infra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author marti
 *  date: 20.07.2018
 */
public class Arquivo {
    private Path savePath;
    private Charset utf8 = StandardCharsets.UTF_8;
    
    //construtor para destinar o caminho
    public Arquivo (String savePath) {
        this.savePath = Paths.get(savePath);
    }
    
    public void salvarLista (List<Long> numeros) throws IOException {
        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(savePath, utf8);
            for(Long numero:numeros) {
                writer.write(numero + "\r\n");
            }
            writer.flush();
            
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer != null) {
                writer.close();
            }
            System.out.println("SALVAMENTO CONCLUIDO");
        }
    }
    
    
    public List carregarLista() throws IOException {
        List numeros = new ArrayList<Long>();
        try (BufferedReader reader = Files.newBufferedReader(savePath, utf8)){            
            String linha = null;
            while( (linha = reader.readLine()) != null) {
                numeros.add( Long.parseLong(linha) );
            }
            reader.close();         
        }
        catch(FileNotFoundException ex) {System.err.println("Arquivo não encontrado");                
        }
        catch(IOException ex) {System.err.println("Erro de leitura");
            ex.printStackTrace();
        }
        catch(NumberFormatException ex) {System.err.println("Erro de formato de numeros");}
        
        return numeros;
    }
    
    
}
