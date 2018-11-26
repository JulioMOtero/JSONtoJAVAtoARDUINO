
package conexao;

import biblioteca.Atalho;
import read.ReadJSONExample;

public class Arduino {
  private ControlePorta arduino;
  ReadJSONExample rje = new ReadJSONExample();
  Atalho atalho = new Atalho();
  /**
   * Constructor class Arduino
   */
  public Arduino(){
      arduino = new ControlePorta("COM5",9600);
  }    
  
   // Send info to serial
  public void comunicacaoArduino(String Atalho) {        

    if(atalho.getNome()!=null){
      arduino.enviaDados(1);
    }
  }
}