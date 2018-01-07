/*
 * S�mtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der �sterreichischen
 * Sozialversicherungstr�ger. Insbesondere ist die Ver�nderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.vdas.soap.constants;

/**
 * Gibt an ob das Todesdatum best�tigt ist (<i>1</i> - JA) oder nicht (<i>0</i> - NEIN). 
 * Wenn der Patient nicht als verstorben gef�hrt wird, bleibt
 * dieses Feld leer (nicht null).
 */
public final class TodesdatumBestaetigt {

  /**
   * Ja.
   */
  public static final String JA = "1";
  
  /**
   * Nein.
   */
  public static final String NEIN = "0";
  
  /**
   * Keine Angabe.
   */
  public static final String KEINE_ANGABE = "";
  
  private TodesdatumBestaetigt() {
  }
  
}
