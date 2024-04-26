#!/bin/bash

# Set the source directory (replace with your actual path)
source_dir="./docs"

# Set the output directory (replace with your desired path)
output_dir="./build/pdf"

# Check if asciidoctor is installed
if ! command -v asciidoctor >/dev/null 2>&1; then
  echo "Error: asciidoctor is not installed. Please install it first."
  exit 1
fi

# Check if asciidoctor-pdf is installed
if ! command -v asciidoctor-pdf >/dev/null 2>&1; then
  echo "Error: asciidoctor-pdf is not installed. Please install it using 'gem install asciidoctor-pdf'."
  exit 1
fi

# Create the output directory if it doesn't exist
mkdir -p "$output_dir"

# Loop through all .adoc files in the source directory
for file in "$source_dir"/*.adoc; do
  # Extract the filename without extension
  filename=$(basename "$file" .adoc)

  # Generate the PDF using asciidoctor-pdf
  asciidoctor-pdf "$file" -o "$output_dir/$filename.pdf"
done

echo "All .adoc files converted successfully!"
