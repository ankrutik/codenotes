#docker

`container-diff` is a tool by Google to diff 2 docker container images

- Setup steps
	- Download container-diff executable from [https://github.com/GoogleContainerTools/container-diff](https://github.com/GoogleContainerTools/container-diff) and add to path
- Usage steps
	1.  Pull your images as needed
		- For MR docker images
			- `docker pull artifacts.company.com/app-docker-image/mr/application:1.2.3.6`
		- For Major docker images
			- `docker pull artifacts.company.com/app-docker-image/application:1.2.0.105`
	2.  List the images
		- `docker image ls`
	3.  Run `container-diff` command in cmd as below
		- `container-diff-windows-amd64.exe diff daemon://artifacts.company.com/app-docker-image/application:1.2.0.105 daemon://artifacts.company.com/app-docker-image/mr/application:1.2.3.6 --type=file  
			- Command option is `diff`
			- The image need to be identified as `daemon://<name>:<tag>`
			- `--type=file` will do a comparison of the file system of the images
		- You will need to shut your browser, intellij, etc. as this uses a lot of memory

## Links

## References
https://github.com/GoogleContainerTools/container-diff
https://www.baeldung.com/ops/docker-differences-between-images

