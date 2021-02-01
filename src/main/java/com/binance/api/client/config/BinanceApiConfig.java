package com.binance.api.client.config;

/**
 * Configuration used for Binance operations.
 */
public class BinanceApiConfig {

	/**
	 * Base domain for URLs.
	 */
	private static String apiBaseUrl ;
	private static String wsBaseUrl ;

	private static String streamApiBaseUrl ;
	private static String assetInfoApiBaseUrl;


	public static String getApiBaseUrl() {
		return apiBaseUrl;
	}

	public static void setApiBaseUrl(String apiBaseUrl) {
		BinanceApiConfig.apiBaseUrl = apiBaseUrl;
	}

	public static String getWsBaseUrl() {
		return wsBaseUrl;
	}

	public static void setWsBaseUrl(String wsBaseUrl) {
		BinanceApiConfig.wsBaseUrl = wsBaseUrl;
	}

	public static String getStreamApiBaseUrl() {
		return streamApiBaseUrl;
	}

	public static void setStreamApiBaseUrl(String streamApiBaseUrl) {
		BinanceApiConfig.streamApiBaseUrl = streamApiBaseUrl;
	}

	public static String getAssetInfoApiBaseUrl() {
		return assetInfoApiBaseUrl;
	}

	public static void setAssetInfoApiBaseUrl(String assetInfoApiBaseUrl) {
		BinanceApiConfig.assetInfoApiBaseUrl = assetInfoApiBaseUrl;
	}
}
