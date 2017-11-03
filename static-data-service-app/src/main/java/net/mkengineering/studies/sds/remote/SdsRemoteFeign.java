package net.mkengineering.studies.sds.remote;

import org.springframework.cloud.netflix.feign.FeignClient;

import net.mkengineering.studies.sds.service.SdsServiceInterface;

@FeignClient(name="static-data-service", url="ryandel.selfhost.me:8802")
public interface SdsRemoteFeign extends SdsServiceInterface{

}
