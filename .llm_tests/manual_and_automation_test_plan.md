**Test Plan for Migrated Java Project**
=====================================

### Unit Test Inventory

#### EMAFilter.java

* `EMAFilter` constructor:
	+ Test case: `EMAFilterTest#testConstructorValidAlpha`
		- Assert: `alpha` is correctly set
	+ Test case: `EMAFilterTest#testConstructorInvalidAlpha`
		- Assert: `IllegalArgumentException` is thrown
* `applyFilter` method:
	+ Test case: `EMAFilterTest#testApplyFilterValidInput`
		- Assert: filtered array is correctly calculated
	+ Test case: `EMAFilterTest#testApplyFilterInvalidInput`
		- Assert: `IllegalArgumentException` is thrown

#### IIRFilter.java

* `IIRFilter` constructor:
	+ Test case: `IIRFilterTest#testConstructorValidOrder`
		- Assert: `order` is correctly set
	+ Test case: `IIRFilterTest#testConstructorInvalidOrder`
		- Assert: `IllegalArgumentException` is thrown
* `applyFilter` method:
	+ Test case: `IIRFilterTest#testApplyFilterValidInput`
		- Assert: filtered array is correctly calculated
	+ Test case: `IIRFilterTest#testApplyFilterInvalidInput`
		- Assert: `IllegalArgumentException` is thrown

#### AllPathsFromSourceToTarget.java

* `findPaths` method:
	+ Test case: `AllPathsFromSourceToTargetTest#testFindPathsValidInput`
		- Assert: all possible paths are correctly found
	+ Test case: `AllPathsFromSourceToTargetTest#testFindPathsInvalidInput`
		- Assert: `IllegalArgumentException` is thrown

### Automated Test Plan

#### Integration/API Checks

* Test case: `IntegrationTest#testEMAFilterIntegration`
	+ Assert: EMA filter is correctly integrated with IIR filter
* Test case: `IntegrationTest#testAllPathsFromSourceToTargetIntegration`
	+ Assert: all paths from source to target are correctly found

#### Regression Suite

* Test case: `RegressionTest#testEMAFilterRegression`
	+ Assert: EMA filter regression test passes
* Test case: `RegressionTest#testIIRFilterRegression`
	+ Assert: IIR filter regression test passes
* Test case: `RegressionTest#testAllPathsFromSourceToTargetRegression`
	+ Assert: all paths from source to target regression test passes

### Manual Test Cases

#### Top User Flows

1. **EMA Filter**
	* Step 1: Create an EMA filter with a valid alpha value
	* Step 2: Apply the filter to an audio signal array
	* Expected result: filtered array is correctly calculated
2. **IIR Filter**
	* Step 1: Create an IIR filter with a valid order value
	* Step 2: Apply the filter to an audio signal array
	* Expected result: filtered array is correctly calculated
3. **All Paths from Source to Target**
	* Step 1: Create a directed graph with a source and target vertex
	* Step 2: Find all possible paths from the source to the target vertex
	* Expected result: all possible paths are correctly found

### Version-Migration Focus

* Tests likely to break due to dependency/runtime version changes:
	+ EMA filter tests that rely on specific audio signal array formats
	+ IIR filter tests that rely on specific coefficient calculations
	+ All paths from source to target tests that rely on specific graph structures