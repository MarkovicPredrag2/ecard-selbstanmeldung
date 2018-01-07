/*
 * S�mtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der �sterreichischen
 * Sozialversicherungstr�ger. Insbesondere ist die Ver�nderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.vdas.soap.constants;

/**
 * Fehlerkonstanten, die bei der Versichertendatenabfrage vom e-card-Serversystem geliefert werden. Fehlercodes siehe
 * {@link at.chipkarte.client.vdas.soap.constants.VdasExceptionConstants VdasExceptionConstants}
 */
public final class VdasExceptionConstants {

  private VdasExceptionConstants() {
    // nothing to do
  }

  /**
   * Die Karte ist ung�ltig. <br>
   * ORCLI-Code: CL-00020, CL-00053 (ZS-00044)
   */
  public static final int INVALID_CARD_EXCEPTION = 1;

  /**
   * Die Signatur ist ung�ltig. <br>
   * ORCLI-Code: CL-00020, CL-00053 (ZS-00043)
   */
  public static final int INVALID_SIGNATURE_EXCEPTION = 2;

  /**
   * Die SV-Nummer existiert nicht oder ist nicht mehr g�ltig. <br>
   * ORCLI-Code: ZS-05011
   */
  public static final int NO_SVPERSON = 26;

  /**
   * Die e-card wird nicht akzeptiert (als gestohlen oder verloren gemeldet). Bitte informieren Sie den Inhaber und �berpr�fen Sie
   * dessen Identit�t.<br>
   * ORCLI-Code: ZS-00099
   */
  public static final int INVALID_CARD_LOST_STOLEN_CHECK_PATIENT = 27;

  /**
   * Die e-card wird nicht akzeptiert (gesperrt, abgelaufen). Bitte informieren Sie den Inhaber und �berpr�fen Sie dessen 
   * Identit�t.<br>
   * ORCLI-Code: ZS-00100
   */
  public static final int INVALID_CARD_CHECK_PATIENT = 28;

  /**
   * Das Backend-Auskunftsservice steht zurzeit nicht zur Verf�gung. Bitte versuchen Sie es zu einem sp�teren Zeitpunkt oder
   * verwenden Sie "Tagesaktuelle Versichertendatenabfrage".
   * <br>ORCLI-Code: ZS-05012
   */
  public static final int BACKENDSYSTEM_NOT_AVAILABLE = 29;

  /**
   * Systemfehler beim Backend-Auskunftsservice.<br>
   * ORCLI-Code: ZS-05014
   */
  public static final int BACKENDSYSTEM_SYSTEM_ERROR = 30;
}
