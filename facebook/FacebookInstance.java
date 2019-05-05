package facebook;

//Librerias de Facebook4j
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;
import facebook4j.Facebook;
import facebook4j.FacebookException;

//Librerias para leer las propiedades
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FacebookInstance {
	private LoggerFacebook log = new LoggerFacebook();
	
	Facebook facebook;
	String accessToken;
	String appID;
	String appSecret;
	String pageID;
	String pageToken;

	public Facebook getFacebook() {
		return facebook;
	}

	public void setFacebook(Facebook facebook) {
		this.facebook = facebook;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAppID() {
		return appID;
	}

	public void setAppID(String appID) {
		this.appID = appID;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getPageID() {
		return pageID;
	}

	public void setPageID(String pageID) {
		this.pageID = pageID;
	}

	public String getPageToken() {
		return pageToken;
	}

	public void setPageToken(String pageToken) {
		this.pageToken = pageToken;
	}

	FacebookInstance(){
		//Iniciamos una instancia de Facebook
		try {	
			//Con las propiedades de nuestro archivo properties
			this.properties();
			//Creamos la instancia 
			this.facebook = new FacebookFactory().getInstance();
			//Asignamos el id de nuestra app y su codigo secreto
			this.facebook.setOAuthAppId(this.appID, this.appSecret);
			//Estipulamos el accessToken 
			this.facebook.setOAuthAccessToken(new AccessToken(accessToken,null));
			//Y especificamos todos los permisos que manejaremos
			this.facebook.setOAuthPermissions("user_birthday, "
					+ "user_hometown, "
					+ "user_location, "
					+ "user_likes, "
					+ "user_events, "
					+ "user_photos, "
					+ "user_videos, "
					+ "user_friends, "
					+ "user_status, "
					+ "user_tagged_places, "
					+ "user_posts, "
					+ "user_gender, "
					+ "user_link, "
					+ "user_age_range, "
					+ "email, "
					+ "read_insights, "
					+ "read_audience_network_insights, "
					+ "publish_video, "
					+ "manage_pages, "
					+ "pages_manage_cta, "
					+ "pages_manage_instant_articles, "
					+ "pages_show_list, "
					+ "publish_pages, "
					+ "read_page_mailboxes, "
					+ "ads_management, "
					+ "ads_read, "
					+ "business_management, "
					+ "pages_messaging, "
					+ "pages_messaging_phone_number, "
					+ "pages_messaging_subscriptions, "
					+ "publish_to_groups, "
					+ "groups_access_member_info, "
					+ "leads_retrieval, "
					+ "public_profile"
					);
		    this.facebook.getPermissions().toString();
		    this.log.loggerInfo("Se ha creado una nueva instancia de Facebook");
		    
		}catch(FacebookException fbex) {
			this.log.loggerInfo("Ha ocurrido un error " + fbex);
		}
		
	}
	
	public void properties() {
        try (InputStream input = new FileInputStream("config/facebook.properties")) {

            Properties prop = new Properties();
            prop.load(input);
            setAccessToken(prop.getProperty("accessToken"));
            setAppID(prop.getProperty("appID"));
            setAppSecret(prop.getProperty("appSecret"));
            setPageID(prop.getProperty("pageID"));
            setPageToken(prop.getProperty("pageToken"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
	
	
}
