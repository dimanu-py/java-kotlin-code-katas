package org.dimanu.deployservice.application;

import org.dimanu.deployservice.domain.Deployment;
import org.dimanu.deployservice.domain.DeploymentRepository;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class DeploymentSearcher {
    private final DeploymentRepository deploymentRepository;

    public DeploymentSearcher(DeploymentRepository deploymentRepository) {
        this.deploymentRepository = deploymentRepository;
    }

    public List<DeploymentResponse> search() {
        List<Deployment> deployments = deploymentRepository.searchAll();
        return deployments.stream()
                .map(this::mapToDeploymentResponse)
                .collect(toList());
    }

    private DeploymentResponse mapToDeploymentResponse(Deployment deployment) {
        Map<String, Object> deploymentValue = deployment.value();
        String version = (String) deploymentValue.get("version");
        Boolean success = (Boolean) deploymentValue.get("success");

        return new DeploymentResponse(version, success);
    }
}
