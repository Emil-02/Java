#!/usr/bin/env bash
# Compiles every folder of exercises on its own (folders are independent
# programs). Sub-folders are added to the sourcepath so package imports resolve.
set -uo pipefail
status=0
while IFS= read -r -d '' dir; do
  mapfile -d '' files < <(find "$dir" -maxdepth 1 -type f -name '*.java' -print0)
  [ ${#files[@]} -eq 0 ] && continue
  sp=$(find "$dir" -type d -not -path '*/.git*' | paste -sd: -)
  out=$(mktemp -d)
  if javac -nowarn -encoding UTF-8 -sourcepath "$sp" -d "$out" "${files[@]}" 2>"$out/err"; then
    echo "ok    $dir"
  else
    echo "::error::compile failed in $dir"; cat "$out/err"; status=1
  fi
  rm -rf "$out"
done < <(find . -type d -not -path './.git*' -not -path './.github*' -print0 | sort -z)
exit $status
