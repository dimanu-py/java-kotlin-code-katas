package org.dimanu.deployservice.infra;

import org.dimanu.deployservice.application.DeploymentResponse;
import org.dimanu.deployservice.application.DeploymentSearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deployments")
public class DeploymentGetController {
    private final DeploymentSearcher deploymentSearcher;

    @Autowired
    public DeploymentGetController(DeploymentSearcher deploymentSearcher) {
        this.deploymentSearcher = deploymentSearcher;
    }

    @GetMapping
    public ResponseEntity<List<DeploymentResponse>> listAllDeployments() {
        List<DeploymentResponse> deployments = deploymentSearcher.search();
        return ResponseEntity.ok(deployments);
    }
}
