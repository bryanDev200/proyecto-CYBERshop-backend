package com.backend.cybershop.service.interfaces;

import com.backend.cybershop.entity.ProductImage;

public interface IProductImageService {
	public ProductImage saveImage(String url, int id);
	public ProductImage getImageByProductId(long productId);
	public void deleteImage(long id);
}