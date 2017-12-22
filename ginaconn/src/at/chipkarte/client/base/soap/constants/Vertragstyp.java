/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */

package at.chipkarte.client.base.soap.constants;



/**
 * Konstanten für den Vertragstyp.
 */
public final class Vertragstyp {

  /**
   * Kurativer Vertrag.
   */
  public static final String KU = "KU";
  /**
   * Vorsorgeuntersuchungsvertrag.
   */
  public static final String GU = "GU";
  /**
   * Hausapothekenvertrag.
   */
  public static final String HAPO = "HAPO";
  /**
   * Rezepturvertrag.
   */
  public static final String REZ = "REZ";
  /**
   * Vertrag mit ELGA-Partnern beziehungsweise Vertrag mit sonstigen Partnern (zum Beispiel FUS-WP).
   */
  public static final String ELGA = "ELGA";
  /**
   * Vertrag mit e-card Partnern HLLF, HBHM, TRANSPORT.
   */
  public static final String EC = "EC";
  /**
   * Apothekenvertrag.
   */
  public static final String APO = "APO";

  private Vertragstyp() {
  }
  
}
