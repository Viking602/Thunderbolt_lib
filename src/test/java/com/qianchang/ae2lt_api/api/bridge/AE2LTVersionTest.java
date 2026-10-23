package com.qianchang.ae2lt_api.api.bridge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AE2LTVersionTest {
    @Test
    void releaseComparisonIgnoresDottedBuildMetadata() {
        assertEquals(0, AE2LTVersion.compareDottedVersions("2.1.2-beta3-viking602.1+26.1.2", "2.1.2"));
        assertEquals(0, AE2LTVersion.compareDottedVersions("1.0.12+26.1.2", "1.0.12"));
        assertTrue(AE2LTVersion.compareDottedVersions("2.1.2-beta3+26.1.2", "2.1.3") < 0);
        assertTrue(AE2LTVersion.compareDottedVersions("2.1.2-beta3+26.1.2", "2.0.9") > 0);
    }

    @Test
    void compatibilityGateRecognizesTheReviewedPortAndStableApi() {
        assertTrue(AE2LTVersion.isKnownCompatibleAE2LTVersion(AE2LTVersion.TARGET_AE2LT_VERSION));
        assertTrue(AE2LTVersion.isKnownCompatibleAE2LTVersion("1.0.12-hotfix1"));
        assertTrue(AE2LTVersion.isKnownCompatibleAE2LTVersion("1.0.1alpha-26.1.2neoforge"));
        assertFalse(AE2LTVersion.isKnownCompatibleAE2LTVersion("3.0.0+26.1.2"));
        assertFalse(AE2LTVersion.isKnownCompatibleAE2LTVersion("1.0.1"));
        assertFalse(AE2LTVersion.isKnownCompatibleAE2LTVersion(null));
    }
}
