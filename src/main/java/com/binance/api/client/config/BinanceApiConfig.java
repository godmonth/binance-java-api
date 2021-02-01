package com.binance.api.client.config;

/**
 * Configuration used for Binance operations.
 */
public class BinanceApiConfig {

	/**
	 * Base domain for URLs.
	 */
	private static String BASE_DOMAIN ;

	private static String apiSubDomain;
	private static String streamSubDomain;

	/**
	 * Set the URL base domain name (e.g., binance.com).
	 *
	 * @param baseDomain Base domain name
	 */
	public static void setBaseDomain(final String baseDomain) {
		BASE_DOMAIN = baseDomain;
	}

	/**
	 * Get the URL base domain name (e.g., binance.com).
	 *
	 * @return The base domain for URLs
	 */
	public static String getBaseDomain() {
		return BASE_DOMAIN;
	}

	/**
	 * REST API base URL.
	 */
	public static String getApiBaseUrl() {
		return String.format("https://%s.%s",getApiSubDomain(), getBaseDomain());
	}


	public static String getApiSubDomain(){return apiSubDomain;	}

	public static void setApiSubDomain(String apiSubDomain) {
		BinanceApiConfig.apiSubDomain = apiSubDomain;
	}

	public static String getStreamSubDomain() {
		return streamSubDomain;
	}

	public static void setStreamSubDomain(String streamSubDomain) {
		BinanceApiConfig.streamSubDomain = streamSubDomain;
	}

	/**
	 * Streaming API base URL.
	 */
	public static String getStreamApiBaseUrl() {
		return String.format("wss://%s.%s/ws",getStreamSubDomain(), getBaseDomain());
	}

	/**
	 * Asset info base URL.
	 */
	public static String getAssetInfoApiBaseUrl() {
		return String.format("https://%s/", getBaseDomain());
	}

}
