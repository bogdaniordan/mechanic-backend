package com.mechanicservice.service;

import com.mechanicservice.aws.BucketName;
import com.mechanicservice.aws.FileStore;
import com.mechanicservice.model.Customer;
import com.mechanicservice.model.User;
import com.mechanicservice.repository.CustomerRepository;
import com.mechanicservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.apache.http.entity.ContentType.*;


@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;
    private final FileStore fileStore;
    private final CustomerService customerService;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unable to find customer with id: " + id));
    }

    public Customer saveCustomer(Customer customer, String username) {
        System.out.println(customer);
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find user with username: " + username));
        customer.setUser(user);
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<User> getAllCredentials() {
        return userRepository.findAll();
    }

    public User addCredentials(User user) {
        return this.userRepository.save(user);
    }

    public Customer customerByUserId(Long id) {
        return customerRepository.findCustomerByUserId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find customer with user id: " + id));
    }

    public Customer customerByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find user"));
        return customerRepository.findCustomerByUserId(user.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Could not find customer with customer id: " + user.getId()));
    }

    public Customer updateCustomer(Customer customer, Long customerId) {
        Customer customerToUpdate = findById(customerId);
        customerToUpdate.setName(customer.getName());
        customerToUpdate.setEmail(customer.getEmail());
        customerToUpdate.setPhoneNumber(customer.getPhoneNumber());
        customerToUpdate.setCity(customer.getCity());
        customerToUpdate.setStreet(customer.getStreet());
        customerToUpdate.setJobPosition(customer.getJobPosition());
        customerToUpdate.setGender(customer.getGender());
        customerToUpdate.setAge(customer.getAge());
        return customerRepository.save(customerToUpdate);
    }


    public Long getCustomerIdByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find user"));
        Customer customer = customerRepository.findCustomerByUserId(user.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Could not find customer with customer id: " + user.getId()));
        return customer.getId();
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find the customer with id: " + id));
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer getCustomerByName(String name) {
        return customerRepository.getCustomerByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find customer with name: " + name));
    }

    public byte[] downloadImage(Long customerId) {
        // path = bucketName + bucketFolder + key
        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), customerId);
        String imageURL = findById(customerId).getPicture();
        return fileStore.download(path, imageURL);
    }

    public void uploadUserProfileImage(Long customerId, MultipartFile file) {
        // 1. Check if image is not empty
        isFileEmpty(file);
        // 2. If file is an image
        isImage(file);

        // 3. The user exists in our database
        Customer customer = customerService.findById(customerId);

        // 4. Grab some metadata from file if any
        Map<String, String> metadata = extractMetadata(file);

        // 5. Store the image in s3 and update database (userProfileImageLink) with s3 image link
        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), customer.getId());
        String filename = file.getOriginalFilename();

        try {
            fileStore.save(path, filename, Optional.of(metadata), file.getInputStream());
            customer.setPicture(filename);
            customerRepository.save(customer);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

    }

    private Map<String, String> extractMetadata(MultipartFile file) {
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));
        return metadata;
    }

    private void isImage(MultipartFile file) {
        if (!Arrays.asList(
                IMAGE_JPEG.getMimeType(),
                IMAGE_PNG.getMimeType(),
                IMAGE_GIF.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("File must be an image [" + file.getContentType() + "]");
        }
    }

    private void isFileEmpty(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file [ " + file.getSize() + "]");
        }
    }
}
