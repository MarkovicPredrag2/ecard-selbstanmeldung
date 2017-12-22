/*
 * Sämtliche Werknutzungs-und Verwertungsrechte an dieser Software liegen beim Hauptverband der österreichischen
 * Sozialversicherungsträger. Insbesondere ist die Veränderung der Software oder einzelner Teile untersagt.
 */
package at.chipkarte.client.base.soap.constants;

/**
 * Konstanten für Berechtigungen im e-card-System.
 */
public final class Berechtigungen {

  private Berechtigungen() {
    // nothing to do
  }
  
  /**
   * Zugriff auf BASE.
   */
  public static final String BASE_CORE = "BASE.CORE";
  /**
   * Zugriff auf KSE (unabhängig von der Kombination aus gewählter Ordination und Tätigkeitsbereich, besteht mindestens ein Vertrag mit Konsultationsrecht).
   */
  public static final String KSE_CORE = "KSE.CORE";
  /**
   * Berechtigt zur Erfassung einer Konsultation im KSE-Service (bei der Kombination aus gewählter Ordination und Tätigkeitsbereich, besteht mindestens ein Vertrag mit Konsultationsrecht).
   */
  public static final String KSE_FULL = "KSE.FULL";
  /**
   * Berechtigt zur Erfassung einer Konsultation mit dem Behandlungsfalls "VM" im Rahmen der Brustkrebs-Früherkennung im KSE-Service.
   */
  public static final String KSE_BKF = "KSE.BKF";
  /**
   * Zugriff auf ABS.
   */
  public static final String ABS_CORE = "ABS.CORE";
  /**
   * Berechtigt zur Erfassung einer Bewilligungsanfrage im Rahmen der Arztbrieferstellung in ABS.
   */
  public static final String ABS_ARZTBRIEF = "ABS.ARZTBRIEF";
  /**
   * Berechtigt zur Erfassung einer Bewilligungsanfrage im Rahmen der Rezeptausstellung in ABS.
   */
  public static final String ABS_REZEPTUR = "ABS.REZEPTUR";
  /**
   * Zugriff auf SAS.
   */
  public static final String SAS_CORE = "SAS.CORE";
  /**
   * Berechtigt zur Adressdatenabfrage in SAS.
   */
  public static final String SAS_ADRESSABFRAGE = "SAS.ADRESSABFRAGE";
  /**
   * Zugriff auf VDAS und Berechtigung zur Abfrage der tagesaktuellen Versichertendaten in VDAS.
   */
  public static final String VDAS_CORE = "VDAS.CORE";
  /**
   * Berechtigt zur stichtagaktuellen Abfrage von Versichertendaten
   * (für ein bestimmtes Datum in der Vergangenheit liegend) sowie zur Anzeige
   * aller Ansprüche eines Patienten bei gemischter Mehrfachversicherung
   * (GKK/BKK-Träger und Sonderversicherungsträger) in VDAS.
   */
  public static final String VDAS_ANSPRUCH_HISTORISCH  = "VDAS.ANSPRUCH_HISTORISCH";
  /**
   * Zugriff auf DMP.
   */
  public static final String DMP_CORE = "DMP.CORE";
  /**
   * Zugriff auf TSV.
   */
  public static final String TSV_CORE = "TSV.CORE";
  /**
   * Zugriff auf AUM.
   */
  public static final String AUM_CORE = "AUM.CORE";
  /**
   * Zugriff auf DBAS.
   */
  public static final String DBAS_CORE = "DBAS.CORE";
  /**
   * Zugriff auf DAS.
   */
  public static final String DAS_CORE = "DAS.CORE";
  /**
   * Berechtigt zur Erfassung einer QZK-Dokumentation in DBAS.
   */
  public static final String DBAS_QZK = "DBAS.QZK";
  /**
   * Zugriff auf PROP (Erfassung eines PROP-Befundes ist nur ohne Konsultationsangabe möglich).
   */
  public static final String PROP_CORE = "PROP.CORE";
  /**
   * Berechtigt zur Erfassung von PROP-Befunden mit Angabe einer Konsultation.
   */
  public static final String PROP_KONSULTATION = "PROP.KONSULTATION";
  /**
   * Zugriff auf BKF.
   */
  public static final String BKF_CORE = "BKF.CORE";
  /**
   * Berechtigt zur Erfassung von Dokumentationen aus dem Früherkennungs-(Screening) oder Kurativen-Bereich 
   * im BKF-Service.
   */
  public static final String BKF_MAMMO = "BKF.MAMMO";
  /**
   * Berechtigt zur Erfassung von Dokumentationen aus dem Assessment- oder Therapiebereich im BKF-Service.
   */
  public static final String BKF_ASSESSMENT = "BKF.ASSESSMENT";
  /**
   * Zugriff auf STS.
   */
  public static final String STS_CORE = "STS.CORE";
  /**
   * Berechtigt zur Abfrage einer Information zum BKF-Leistungsanspruch.
   */  
  public static final String BKF_LA_ABFRAGE = "BKF.LA_ABFRAGE";
  /**
   * Zugriff auf EBS.
   */  
  public static final String EBS_CORE = "EBS.CORE";
  /**
   * Erlaubt die Erfassung eines Antrags.
   */  
  public static final String EBS_ANTRAG = "EBS.ANTRAG";
  /**
   * Erlaubt die Übernahme von Leistungen eines Antrags.
   */  
  public static final String EBS_UEBERNAHME = "EBS.UEBERNAHME";
  /**
   * Zugriff auf ELGATSV.
   */  
  public static final String ELGATSV_CORE = "ELGATSV.CORE";
  /**
   * Zugriff auf ELGAAD (ELGA Adapter).
   */  
  public static final String ELGAAD_CORE = "ELGAAD.CORE";
  /**
   * Erlaubt den Zugriff auf Funktionen des ELGA Adapters, die eine ELGA Authentifizierung benötigen. <br>
   */
  public static final String ELGAAD_AUTH = "ELGAAD.AUTH";
  /**
   * Erlaubt den Zugriff auf e-Medikations-Funktionen des ELGA Adapters. <br>
   */
  public static final String ELGAAD_MEDIKATION = "ELGAAD.MEDIKATION";
  /**
   * Erlaubt den Zugriff auf e-Befund-Funktionen des ELGA Adapters. <br>
   */
  public static final String ELGAAD_BEFUND = "ELGAAD.BEFUND";
  /**
   * Zugriff auf FUS. <br>
   */
  public static final String FUS_CORE = "FUS.CORE";
  /**
   * Erlaubt die Erfassung von KFO-Formularen als FUS-Vertragspartner. <br>
   */
  public static final String FUS_VP = "FUS.VP";
  /**
   * Erlaubt die Erfassung von KFO-Formularen als FUS-Wahlbehandler. <br>
   */
  public static final String FUS_WP = "FUS.WP";
  /**
   * Erlaubt die Erfassung von EKV-Formularen. <br>
   */
  public static final String FUS_EK = "FUS.EK";
 
}
