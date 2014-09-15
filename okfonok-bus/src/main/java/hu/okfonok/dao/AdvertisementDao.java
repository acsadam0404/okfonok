package hu.okfonok.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.okfonok.entities.Advertisement;
import hu.okfonok.entities.user.User;

public interface AdvertisementDao extends JpaRepository<Advertisement, Long> {
	List<Advertisement> findByUser(User user);
}
