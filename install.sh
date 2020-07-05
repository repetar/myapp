#!/bin/bash

NAMESPACE=0

function usage() {

 cat <<EOF

Usage:
  $(basename $0) [options]

  This script is used to build and upload source images.
  Options:
    --install <namespace>: Install mongodb and application in the given nmespace.
    --help  | -h : help

EOF
}

function parse_arguments() {

    PARSED_OPTIONS=$(getopt -n "$0" -o h  -l help,namespace -- "$@")
    OPTION_RET=$?
    eval set -- "${PARSED_OPTIONS}"
    if [[ ${OPTION_RET} -ne 0 ]]
    then
        usage
        exit 1
    fi

    while [[ $# -ge 1 ]]
    do
        case $1 in
            --namespace )
            shift;
            shift;
            if [[ ! -z "$1" ]]; then
              NAMESPACE=$1
            else
              echo "Please provide non-existing namespace for installation"
              exit 1
            fi
            shift
            ;;
            -h | --help ) usage;exit 0;;
            -- ) shift;break;;
            * ) "Unsupported parameter $1";exit 2;;
        esac
        shift
    done
}

function main() {

  parse_arguments $@

  kubectl get namespace ${NAMESPACE}

  if [[ $? -ne 1 ]];
  then
    echo "Namespace exists. Provide non-existing namespace name. We don't want to delete any of your work."
    exit 1
  fi

  kubectl create namespace ${NAMESPACE}

  kubectl get crd/mongodb.mongodb.com

  if [[ $? -eq 1 ]]; then
    kubectl create -f chart/mongodb/crds/mongodb.com_mongodb_crd.yaml --namespace ${NAMESPACE}
  fi

  kubectl create -f chart/mongodb/ --namespace ${NAMESPACE}

  kubectl apply -f chart/mongodb/crds/mongodb.com_v1_mongodb_cr.yaml --namespace ${NAMESPACE}

  helm install chart/my-app/ --namespace ${NAMESPACE}

  clusterip=$(kubectl get svc fe-service -o jsonpath='{.spec.clusterIP}' --namespace ${NAMESPACE})

  echo  "######################################################################################"
  echo  "Application succesfully deployed. You can access the product page on ${clusterip}:8080 once all the PODs are up."


}

main $@