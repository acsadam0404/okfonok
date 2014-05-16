package hu.okfonok.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.okfonok.entities.Advertisement;

public interface AdvertisementDao extends JpaRepository<Advertisement, Long> {

}
