package org.dimanu.deployservice.infra;

import org.dimanu.deployservice.application.DeploymentResponse;
import org.dimanu.deployservice.application.DeploymentSearcher;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class DeploymentGetController {
    private final DeploymentSearcher deploymentSearcher;

    public DeploymentGetController(DeploymentSearcher deploymentSearcher) {
        this.deploymentSearcher = deploymentSearcher;
    }

    public ResponseEntity<List<DeploymentResponse>> listAllDeployments() {
        List<DeploymentResponse> deployments = deploymentSearcher.search();
        return ResponseEntity.ok(deployments);
    }
}
