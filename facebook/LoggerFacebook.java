package facebook;

//Log4j para la creacion de logs
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerFacebook {
	private static Logger logger = LogManager.getLogger(LoggerFacebook.class);

	public void loggerInfo(String message) {
		logger.info(message);
	}
}
