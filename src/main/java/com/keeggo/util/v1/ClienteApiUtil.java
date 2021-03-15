package com.keeggo.util.v1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ClienteApiUtil {
	/**
	 * Field to represent API version on the requests/responses header
	 */
	public static final String HEADER_TRAVELS_API_VERSION = "Clientes-api-version-1";
	
	/**
	 * Field to represent API key on the requests/responses header
	 */
	public static final String HEADER_API_KEY = "X-api-key";
	
	/**
	 * Field to represent API Rate Limit Remaining on the requests/responses header
	 */
	public static final String HEADER_LIMIT_REMAINING = "X-Rate-Limit-Remaining";
    
	/**
	 * Field to represent API Rate Limit Retry After Seconds on the requests/responses header
	 */
	public static final String HEADER_RETRY_AFTER = "X-Rate-Limit-Retry-After-Seconds";
	
	private ClienteApiUtil() {}
	
	/**
	 * Method that check if the Travel is being created in the future.
	 * 
	 * @author Mariana Azevedo
	 * @since 08/09/2019
	 * 
	 * @param travel
	 * @return boolean
	 
	public static boolean isTravelEndDateGreaterThanStartDate(Cliente cliente) {
		if(cliente.getEndDate() == null) return true;
		return cliente.getEndDate().isAfter(cliente.getStartDate());
	}
	
	/**
	 * Method that check if the TravelDTO is being created in the future.
	 * 
	 * @author Mariana Azevedo
	 * @since 01/04/2020
	 * 
	 * @param dto
	 * @return boolean
	 
	public static boolean isTravelDTOEndDateGreaterThanStartDate(ClienteDTO dto) {
		if(dto.getEndDate() == null) return true;
		return dto.getEndDate().isAfter(dto.getStartDate());
	}
	
	/**
	 * Method that format a date as yyyy-MM-dd.
	 * 
	 * @author Mariana Azevedo
	 * @since 21/08/2020
	 * 
	 * @return <code>DateTimeFormatter</code> object
	 */
	public static DateTimeFormatter getDateFormater() {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd");
	}
	
	/**
	 * Method that format a date as yyyy-MM-dd'T'HH:mm:ss.SSS'Z'.
	 * 
	 * @author Mariana Azevedo
	 * @since 21/08/2020
	 * 
	 * @return <code>DateTimeFormatter</code> object
	 */
	public static DateTimeFormatter getDateTimeFormater() {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	}
	
	/**
	 * Method that converts a string to a LocalDateTime.
	 * 
	 * @author Mariana Azevedo
	 * @since 23/08/2020
	 * 
	 * @param dateAsString
	 * 
	 * @return <code>LocalDateTime</code> object
	 * @throws ParseException
	 */
	public static LocalDateTime getLocalDateTimeFromString(String dateAsString) throws ParseException{
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Date dateISO8601 = inputFormat.parse(dateAsString);
        return dateISO8601.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
	
	/**
	 * Method that converts a local date to a local date time.
	 * 
	 * @author Mariana Azevedo
	 * @since 23/08/2020
	 * 
	 * @param date
	 * @return <code>LocalDateTime</code> object
	 */
	public static LocalDateTime convertLocalDateToLocalDateTime(LocalDate date) {
		return date.atTime(0, 0, 0);
	}
}
