package io.jbonn360.moviecatalogservice.model;

import java.util.List;

public class MovieCatalog {
	private final List<CatalogItem> catalogItems;
	
	public MovieCatalog(List<CatalogItem> catalogItems) {
		this.catalogItems = catalogItems;
	}

	public List<CatalogItem> getCatalogItems() {
		return catalogItems;
	}
}
