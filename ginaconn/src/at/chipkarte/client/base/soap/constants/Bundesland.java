/*
 * S�mtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der �sterreichischen
 * Sozialversicherungstr�ger. Insbesondere ist die Ver�nderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap.constants;

/**
 * Konstanten f�r L�nder.
 * 
 * @ecardOk rule=ConstantNameCheck changing constant names on the SS12 interface is not advisable
 * @ecardOk rule=JavadocVariableCheck no need for further documentation
 */
public final class Bundesland {

  private Bundesland() {
    // nothing to do
  }
  
  public static final String AUSLAND = "0";
  public static final String WIEN = "1";
  public static final String NIEDEROESTERREICH = "2";
  public static final String BURGENLAND = "3";
  public static final String OBEROESTERREICH = "4";
  public static final String STEIERMARK = "5";
  public static final String KAERNTEN = "6";
  public static final String SALZBURG = "7";
  public static final String TIROL = "8";
  public static final String VORARLBERG = "9";

}
